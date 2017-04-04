
class A{
  def hi ="hello from a"
  override def toString = getClass.getName
}
class B extends A
class C extends B {
 override def hi = "hi C=>" + super.hi
}
val hia= new A()
val hib=new B().hi
val hic=new C().hi

val a:A=new A
val b =new B
val ab:A =new B

val la = List(1,2,3)
val le=List()


