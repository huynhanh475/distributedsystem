package Counter;

/**
* Counter/CountHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./com/year3/distributedsystem/lecture4/corba/Count.idl
* Friday, April 1, 2022 8:00:24 PM ICT
*/

public final class CountHolder implements org.omg.CORBA.portable.Streamable
{
  public Counter.Count value = null;

  public CountHolder ()
  {
  }

  public CountHolder (Counter.Count initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Counter.CountHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Counter.CountHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Counter.CountHelper.type ();
  }

}
