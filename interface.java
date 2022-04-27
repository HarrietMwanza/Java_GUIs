interface MyInterface
{
   /* compiler will treat them as: 
    * public abstract void method1();
    * public abstract void method2();
    */
   public void method1();
   public void method2();
}
class Demo implements MyInterface
{
   /* This class must have to implement both the abstract methods
    * else you will get compilation error
    */
   public void method1()
   {
	System.out.println("I enjoy icecream");
   }
   public void method2()
   {
	System.out.println("I am an ALU student in my second year");
   }
   public static void main(String arg[])
   {
	MyInterface obj = new Demo();
	obj.method1();
   }
}
