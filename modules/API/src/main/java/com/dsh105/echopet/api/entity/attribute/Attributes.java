package com.dsh105.echopet.api.entity.attribute;

import com.dsh105.commodus.GeneralUtil;
import com.dsh105.commodus.reflection.Reflection;
import com.dsh105.echopet.api.entity.Entity;
import com.dsh105.echopet.api.entity.PetType;
import com.dsh105.echopet.api.entity.Traits;
import com.dsh105.echopet.api.entity.Voice;
import com.dsh105.echopet.api.entity.entitypet.EntityAgeablePet;
import com.dsh105.echopet.api.entity.entitypet.EntityEquipablePet;
import com.dsh105.echopet.api.entity.entitypet.EntityPet;
import com.dsh105.echopet.api.entity.entitypet.EntityRangedPet;
import com.dsh105.echopet.api.entity.pet.AgeablePet;
import com.dsh105.echopet.api.entity.pet.EquipablePet;
import com.dsh105.echopet.api.entity.pet.Pet;
import com.dsh105.echopet.api.entity.pet.RangedPet;
import org.bukkit.DyeColor;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Villager;

import java.lang.reflect.Field;
import java.util.*;

public class Attributes
{

    private static final SortedMap<Integer, AttributeEnumBridge> ORDINAL_MAP = new TreeMap<>();
    private static final Map<AttributeEnumBridge, Integer> INVERSE_ORDINAL_MAP = new HashMap<>();
    private static final Map<Class<? extends AttributeEnumBridge>, Map<String, AttributeEnumBridge>> PER_CLASS_NAME_MAP = new HashMap<>();
    private static final Map<Class<? extends AttributeEnumBridge>, Map<AttributeEnumBridge, String>> INVERSE_PER_CLASS_NAME_MAP = new HashMap<>();
    private static final Map<Class<? extends AttributeEnumBridge>, Map<Integer, AttributeEnumBridge>> PER_CLASS_ORDINAL_MAP = new HashMap<>();
    private static final Map<Class<? extends AttributeEnumBridge>, Map<AttributeEnumBridge, Integer>> INVERSE_PER_CLASS_ORDINAL_MAP = new HashMap<>();

    private static final Map<Class<? extends Pet>, Traits> TRAITS_MAP = new HashMap<>();
    private static final Map<Class<? extends Pet>, Voice> VOICE_MAP = new HashMap<>();
    private static final Map<Class<? extends EntityPet>, Entity> ENTITY_TRAITS_MAP = new HashMap<>();
    private static final Map<Class<? extends Pet>, List<Class<? extends Pet>>> PET_CLASS_MAP = new HashMap<>();
    private static final Map<Class<? extends EntityPet>, List<Class<? extends EntityPet>>> ENTITY_CLASS_MAP = new HashMap<>();
    private static final Map<Class<? extends Pet>, Class<? extends EntityPet>> PET_TO_ENTITY_CLASS_MAP = new HashMap<>();
    private static final Map<Class<? extends EntityPet>, Class<? extends Pet>> INVERSE_PET_TO_ENTITY_CLASS_MAP = new HashMap<>();

    static
    {
        // initialise everything
        Class<?>[] nestedClasses = Attributes.class.getDeclaredClasses();
        for (int i = 0; i < nestedClasses.length; i += 100)
        {
            Class<?> nestedClass = nestedClasses[i];

            if (AttributeEnumBridge.class.isAssignableFrom(nestedClass))
            {

                Class<? extends AttributeEnumBridge> entityEnumBridge = (Class<? extends AttributeEnumBridge>) nestedClass;

                Map<String, AttributeEnumBridge> nameMap = new HashMap<>();
                Map<Integer, AttributeEnumBridge> ordinalMap = new HashMap<>();
                Field[] candidateFields = entityEnumBridge.getDeclaredFields();
                for (int j = 0; j < candidateFields.length; j++)
                {
                    Field field = candidateFields[j];
                    if (AttributeEnumBridge.class.isAssignableFrom(field.getType()))
                    {
                        AttributeEnumBridge enumBridge = (AttributeEnumBridge) Reflection.getFieldValue(field, (Object) null);
                        nameMap.put(field.getName(), enumBridge);
                        ordinalMap.put(j, enumBridge);

                        ORDINAL_MAP.put(i + j, enumBridge);
                    }
                }

                PER_CLASS_NAME_MAP.put(entityEnumBridge, Collections.unmodifiableMap(nameMap));
                PER_CLASS_ORDINAL_MAP.put(entityEnumBridge, Collections.unmodifiableMap(ordinalMap));

                INVERSE_PER_CLASS_NAME_MAP.put(entityEnumBridge, Collections.unmodifiableMap(GeneralUtil.invertMap(nameMap)));
                INVERSE_PER_CLASS_ORDINAL_MAP.put(entityEnumBridge, Collections.unmodifiableMap(GeneralUtil.invertMap(ordinalMap)));
            }
        }

        INVERSE_ORDINAL_MAP.putAll(GeneralUtil.invertMap(ORDINAL_MAP));

        for (PetType petType : PetType.values())
        {
            List<Class<? extends Pet>> petClasses = new ArrayList<>();
            List<Class<? extends EntityPet>> entityClasses = new ArrayList<>();

            // Lowest entity class
            Class<? extends EntityPet> lowEntityClass = petType.getEntityClass();
            // Lowest pet class
            Class<? extends Pet> lowPetClass = petType.getPetClass();

            // highest type interface; marked with @Traits
            Class<? extends Pet> annotatedPetClass = lowPetClass;
            // highest entity type interface; marked with @Entity
            Class<? extends EntityPet> annotatedEntityClass = lowEntityClass;

            List<Class<? extends Pet>> ignoredPetClasses = Arrays.asList(Pet.class, AgeablePet.class, EquipablePet.class, RangedPet.class);

            for (Class<?> iface : lowPetClass.getInterfaces())
            {
                if (ignoredPetClasses.contains(iface) || !Pet.class.isAssignableFrom(iface))
                {
                    continue;
                }
                Class<? extends Pet> petIface = (Class<? extends Pet>) iface;
                if (petIface.getAnnotation(Traits.class) != null)
                {
                    annotatedPetClass = petIface;
                }
                else
                {
                    petClasses.add(petIface);
                }
            }

            List<Class<? extends EntityPet>> ignoredEntityClasses = Arrays.asList(EntityPet.class, EntityAgeablePet.class, EntityEquipablePet.class, EntityRangedPet.class);

            for (Class<?> iface : lowEntityClass.getInterfaces())
            {
                if (ignoredEntityClasses.contains(iface) || !EntityPet.class.isAssignableFrom(iface))
                {
                    continue;
                }
                Class<? extends EntityPet> entityIface = (Class<? extends EntityPet>) iface;
                if (entityIface.getAnnotation(Entity.class) != null)
                {
                    annotatedEntityClass = entityIface;
                }
                else
                {
                    entityClasses.add(entityIface);
                }
            }

            TRAITS_MAP.put(annotatedPetClass, annotatedEntityClass.getAnnotation(Traits.class));
            // may be null
            VOICE_MAP.put(annotatedPetClass, annotatedEntityClass.getAnnotation(Voice.class));

            ENTITY_TRAITS_MAP.put(annotatedEntityClass, annotatedEntityClass.getAnnotation(Entity.class));

            PET_CLASS_MAP.put(annotatedPetClass, petClasses);
            ENTITY_CLASS_MAP.put(annotatedEntityClass, entityClasses);

            PET_TO_ENTITY_CLASS_MAP.put(annotatedPetClass, annotatedEntityClass);
        }

        INVERSE_PET_TO_ENTITY_CLASS_MAP.putAll(GeneralUtil.invertMap(PET_TO_ENTITY_CLASS_MAP));
    }

    public static <T extends Pet> Class<T> getPetClass(Class<T> petClass)
    {
        for (Class<? extends Pet> c : PET_CLASS_MAP.keySet())
        {
            if (c.equals(petClass) || PET_CLASS_MAP.get(c).contains(petClass))
            {
                return (Class<T>) c;
            }
        }
        return null;
    }

    public static <E extends EntityPet> Class<? extends Pet<?, E>> getPetClassOf(Class<E> entityPetClass)
    {
        return (Class<? extends Pet<?, E>>) INVERSE_PET_TO_ENTITY_CLASS_MAP.get(entityPetClass);
    }

    public static <P extends Pet> Class<? extends EntityPet<P>> getEntityClassOf(Class<P> petClass)
    {
        return (Class<? extends EntityPet<P>>) PET_TO_ENTITY_CLASS_MAP.get(petClass);
    }

    public static <T extends EntityPet> Class<T> getEntityClass(Class<T> petEntityClass)
    {
        for (Class<? extends EntityPet> c : ENTITY_CLASS_MAP.keySet())
        {
            if (ENTITY_CLASS_MAP.get(c).contains(petEntityClass))
            {
                return (Class<T>) c;
            }
        }
        return null;
    }

    public static Voice getVoice(PetType petType)
    {
        Class<? extends Pet> petClass = getPetClass(petType.getPetClass());
        if (petClass != null)
        {
            return VOICE_MAP.get(petClass);
        }
        return null;
    }

    public static Traits getTraits(PetType petType)
    {
        Class<? extends Pet> petClass = getPetClass(petType.getPetClass());
        if (petClass != null)
        {
            return TRAITS_MAP.get(petClass);
        }
        return null;
    }

    public static String getIdleSound(PetType petType)
    {
        Voice voice = getVoice(petType);
        return voice != null ? voice.idle() : "default";
    }

    public static String getHurtSound(PetType petType)
    {
        Voice voice = getVoice(petType);
        return voice != null ? voice.hurt() : ""; // TODO: idle?
    }

    public static String getDeathSound(PetType petType)
    {
        Voice voice = getVoice(petType);
        return voice != null ? voice.death() : "default";
    }

    public static String getStepSound(PetType petType)
    {
        Voice voice = getVoice(petType);
        return voice != null ? voice.step() : "";
    }

    public static Class<?> getClassByName(String name)
    {
        for (Class<?> candidate : Attributes.class.getDeclaredClasses())
        {
            if (candidate.getSimpleName().equals(name))
            {
                return candidate;
            }
        }
        return null;
    }

    // TODO: write tests to see that these are always in order
    public static List<AttributeEnumBridge> values()
    {
        List<AttributeEnumBridge> enumBridges = new ArrayList<>();
        Collections.addAll(ORDINAL_MAP.values());
        return Collections.unmodifiableList(enumBridges);
    }

    public static EntityAttribute valueOf(String className, String fieldName)
    {
        Class<?> enclosingClass = getClassByName(className);
        if (enclosingClass == null)
        {
            return null;
        }

        if (enclosingClass.isEnum())
        {
            return (EntityAttribute) Enum.valueOf((Class<? extends Enum<?>>) enclosingClass, fieldName.toUpperCase().replace(" ", "_"));
        }
        else if (AttributeEnumBridge.class.isAssignableFrom(enclosingClass))
        {
            return valueOf((Class<AttributeEnumBridge>) enclosingClass, fieldName);
        }
        return null;
    }

    public static <E extends AttributeEnumBridge> List<E> values(Class<E> attributeEnumBridgeType)
    {
        List<E> enumBridges = new ArrayList<>();
        enumBridges.addAll((Collection<? extends E>) PER_CLASS_NAME_MAP.get(attributeEnumBridgeType).values());
        return Collections.unmodifiableList(enumBridges);
    }

    public static <E extends AttributeEnumBridge> Map<String, E> valuesByName(Class<E> attributeEnumBridgeType)
    {
        Map<String, E> values = (Map<String, E>) PER_CLASS_NAME_MAP.get(attributeEnumBridgeType);
        if (values == null)
        {
            values = new HashMap<>();
        }
        return Collections.unmodifiableMap(values);
    }

    public static <E extends AttributeEnumBridge> E valueOf(Class<E> attributeEnumBridgeType, String name)
    {
        return valueOf(attributeEnumBridgeType, name, true);
    }

    public static <E extends AttributeEnumBridge> E valueOf(Class<E> attributeEnumBridgeType, String name, boolean allowTransformation)
    {
        AttributeEnumBridge enumBridge = valuesByName(attributeEnumBridgeType).get(name);
        return enumBridge != null ? (E) enumBridge : (allowTransformation ? valuesByName(attributeEnumBridgeType).get(name.toUpperCase().replace(" ", "_")) : null);
    }

    public static <E extends AttributeEnumBridge> E valueOf(Class<E> entityEnumBridgeType, int ordinal)
    {
        return (E) PER_CLASS_ORDINAL_MAP.get(entityEnumBridgeType).get(ordinal);
    }

    public static String nameOf(Class<? extends AttributeEnumBridge> attributeEnumBridgeType, AttributeEnumBridge attributeEnumBridge)
    {
        return INVERSE_PER_CLASS_NAME_MAP.get(attributeEnumBridgeType).get(attributeEnumBridge);
    }

    public static int ordinalOf(Class<? extends AttributeEnumBridge> attributeEnumBridgeType, AttributeEnumBridge attributeEnumBridge)
    {
        return INVERSE_PER_CLASS_ORDINAL_MAP.get(attributeEnumBridgeType).get(attributeEnumBridge);
    }

    public static int ordinalOf(AttributeEnumBridge attributeEnumBridge)
    {
        return INVERSE_ORDINAL_MAP.get(attributeEnumBridge);
    }

    public static AttributeEnumBridge valueOf(int ordinal)
    {
        return ORDINAL_MAP.get(ordinal);
    }

    /*
     * Attributes and enum bridges
     */

    public enum Attribute implements EntityAttribute
    {
        ANGRY,
        ASLEEP,
        BABY,
        CHESTED,
        FIRE,
        IGNITION,
        POWER,
        ROSE,
        SADDLE,
        SCREAMING,
        SHEARED,
        SHIELD,
        TAME,
        VILLAGER,
        WITHER;

        @Override
        public AttributeType getType()
        {
            return AttributeType.SWITCH;
        }
    }

    public enum SlimeSize implements EntityAttribute
    {
        SMALL(1),
        MEDIUM(2),
        LARGE(4);

        private int size;

        SlimeSize(int size)
        {
            this.size = size;
        }

        public static SlimeSize getBySize(int size)
        {
            for (SlimeSize slimeSize : values())
            {
                if (slimeSize.getSize() == size)
                {
                    return slimeSize;
                }
            }
            return null;
        }

        public int getSize()
        {
            return size;
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.SLIME_SIZE;
        }


    }

    public enum HorseArmour implements EntityAttribute
    {
        NONE,
        IRON,
        GOLD,
        DIAMOND;

        @Override
        public AttributeType getType()
        {
            return AttributeType.HORSE_ARMOUR;
        }
    }

    public static class Color extends AttributeEnumBridge<DyeColor>
    {

        public static final Color
                WHITE = new Color(DyeColor.WHITE),
                ORANGE = new Color(DyeColor.ORANGE),
                MAGENTA = new Color(DyeColor.MAGENTA),
                LIGHT_BLUE = new Color(DyeColor.LIGHT_BLUE),
                YELLOW = new Color(DyeColor.YELLOW),
                LIME = new Color(DyeColor.LIME),
                PINK = new Color(DyeColor.PINK),
                GRAY = new Color(DyeColor.GRAY),
                SILVER = new Color(DyeColor.SILVER),
                CYAN = new Color(DyeColor.CYAN),
                PURPLE = new Color(DyeColor.PURPLE),
                BLUE = new Color(DyeColor.BLUE),
                BROWN = new Color(DyeColor.BROWN),
                GREEN = new Color(DyeColor.GREEN),
                RED = new Color(DyeColor.RED),
                BLACK = new Color(DyeColor.BLACK);

        public Color(DyeColor bukkitEquivalent)
        {
            super(bukkitEquivalent);
        }

        public static Color[] values()
        {
            return values(Color.class);
        }

        public static Color valueOf(String name)
        {
            return valueOf(Color.class, name);
        }

        public static Color valueOf(String name, boolean allowTransformation)
        {
            return valueOf(Color.class, name, allowTransformation);
        }

        public static Color valueOf(int ordinal)
        {
            return valueOf(Color.class, ordinal);
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.COLOR;
        }
    }

    public static class HorseColor extends AttributeEnumBridge<Horse.Color>
    {

        public static final HorseColor
                WHITE = new HorseColor(Horse.Color.WHITE),
                CREAMY = new HorseColor(Horse.Color.CREAMY),
                CHESTNUT = new HorseColor(Horse.Color.CHESTNUT),
                BROWN = new HorseColor(Horse.Color.BROWN),
                BLACK = new HorseColor(Horse.Color.BLACK),
                GRAY = new HorseColor(Horse.Color.GRAY),
                DARK_BROWN = new HorseColor(Horse.Color.DARK_BROWN);

        public HorseColor(Horse.Color bukkitEquivalent)
        {
            super(bukkitEquivalent);
        }

        public static HorseColor[] values()
        {
            return values(HorseColor.class);
        }

        public static HorseColor valueOf(String name)
        {
            return valueOf(HorseColor.class, name);
        }

        public static HorseColor valueOf(String name, boolean allowTransformation)
        {
            return valueOf(HorseColor.class, name, allowTransformation);
        }

        public static HorseColor valueOf(int ordinal)
        {
            return valueOf(HorseColor.class, ordinal);
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.HORSE_COLOUR;
        }

    }

    public static class HorseStyle extends AttributeEnumBridge<Horse.Style>
    {

        public static final AttributeEnumBridge
                NONE = new HorseStyle(Horse.Style.NONE),
                WHITE = new HorseStyle(Horse.Style.WHITE),
                WHITEFIELD = new HorseStyle(Horse.Style.WHITEFIELD),
                WHITE_DOTS = new HorseStyle(Horse.Style.WHITE_DOTS),
                BLACK_DOTS = new HorseStyle(Horse.Style.BLACK_DOTS);

        public HorseStyle(Horse.Style bukkitEquivalent)
        {
            super(bukkitEquivalent);
        }

        public static HorseStyle[] values()
        {
            return values(HorseStyle.class);
        }

        public static HorseStyle valueOf(String name)
        {
            return valueOf(HorseStyle.class, name);
        }

        public static HorseStyle valueOf(String name, boolean allowTransformation)
        {
            return valueOf(HorseStyle.class, name, allowTransformation);
        }

        public static HorseStyle valueOf(int ordinal)
        {
            return valueOf(HorseStyle.class, ordinal);
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.HORSE_STYLE;
        }

    }

    public static class HorseVariant extends AttributeEnumBridge<Horse.Variant>
    {

        public static final HorseVariant
                NORMAL = new HorseVariant(Horse.Variant.HORSE),
                DONKEY = new HorseVariant(Horse.Variant.DONKEY),
                MULE = new HorseVariant(Horse.Variant.MULE),
                ZOMBIE = new HorseVariant(Horse.Variant.UNDEAD_HORSE),
                SKELETON = new HorseVariant(Horse.Variant.SKELETON_HORSE);

        public HorseVariant(Horse.Variant bukkitEquivalent)
        {
            super(bukkitEquivalent);
        }

        public static HorseVariant[] values()
        {
            return values(HorseVariant.class);
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.HORSE_VARIANT;
        }

    }

    public static class OcelotType extends AttributeEnumBridge<Ocelot.Type>
    {

        public static final OcelotType
                WILD = new OcelotType(Ocelot.Type.WILD_OCELOT),
                BLACK = new OcelotType(Ocelot.Type.BLACK_CAT),
                RED = new OcelotType(Ocelot.Type.RED_CAT),
                SIAMESE = new OcelotType(Ocelot.Type.SIAMESE_CAT);

        public OcelotType(Ocelot.Type bukkitEquivalent)
        {
            super(bukkitEquivalent);
        }

        public static OcelotType[] values()
        {
            return values(OcelotType.class);
        }

        public static OcelotType valueOf(String name)
        {
            return valueOf(OcelotType.class, name);
        }

        public static OcelotType valueOf(String name, boolean allowTransformation)
        {
            return valueOf(OcelotType.class, name, allowTransformation);
        }

        public static OcelotType valueOf(int ordinal)
        {
            return valueOf(OcelotType.class, ordinal);
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.OCELOT_TYPE;
        }

    }

    public static class SkeletonType extends AttributeEnumBridge<Skeleton.SkeletonType>
    {

        public static final SkeletonType
                NORMAL = new SkeletonType(Skeleton.SkeletonType.NORMAL),
                WITHER = new SkeletonType(Skeleton.SkeletonType.WITHER);

        public SkeletonType(Skeleton.SkeletonType bukkitEquivalent)
        {
            super(bukkitEquivalent);
        }

        public static SkeletonType[] values()
        {
            return values(SkeletonType.class);
        }

        public static SkeletonType valueOf(String name)
        {
            return valueOf(SkeletonType.class, name);
        }

        public static SkeletonType valueOf(String name, boolean allowTransformation)
        {
            return valueOf(SkeletonType.class, name, allowTransformation);
        }

        public static SkeletonType valueOf(int ordinal)
        {
            return valueOf(SkeletonType.class, ordinal);
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.SKELETON_TYPE;
        }

    }

    public static class VillagerProfession extends AttributeEnumBridge<Villager.Profession>
    {

        public static final VillagerProfession
                FARMER = new VillagerProfession(Villager.Profession.FARMER),
                LIBRARIAN = new VillagerProfession(Villager.Profession.LIBRARIAN),
                PRIEST = new VillagerProfession(Villager.Profession.PRIEST),
                BLACKSMITH = new VillagerProfession(Villager.Profession.BLACKSMITH),
                BUTCHER = new VillagerProfession(Villager.Profession.BUTCHER);

        public VillagerProfession(Villager.Profession bukkitEquivalent)
        {
            super(bukkitEquivalent);
        }

        public static VillagerProfession[] values()
        {
            return values(VillagerProfession.class);
        }

        public static VillagerProfession valueOf(String name)
        {
            return valueOf(VillagerProfession.class, name);
        }

        public static VillagerProfession valueOf(String name, boolean allowTransformation)
        {
            return valueOf(VillagerProfession.class, name, allowTransformation);
        }

        public static VillagerProfession valueOf(int ordinal)
        {
            return valueOf(VillagerProfession.class, ordinal);
        }

        @Override
        public AttributeType getType()
        {
            return AttributeType.PROFESSION;
        }

    }

}