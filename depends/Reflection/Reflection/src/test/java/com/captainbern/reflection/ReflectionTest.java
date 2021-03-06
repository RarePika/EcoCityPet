package com.captainbern.reflection;

public class ReflectionTest
{
    public static void main(String[] args)
    {
        System.out.println("Injecting a new Enum type!");

        EnumModifier<Test> enumModifier = new Reflection().newEnumModifier(Test.class);

        enumModifier.addEnumValue("ANOTHER_ENUM", "Test Passed!");

        System.out.println("Injection done");
        System.out.println("---------------");

        for (Test val : Test.values())
        {
            System.out.println(val.name());
        }
    }

    private enum Test
    {

        SOME_ENUM("Test");

        final String value;

        Test(String value)
        {
            this.value = value;
        }
    }
}