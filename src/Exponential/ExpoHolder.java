package Exponential;

/**
* Exponential/ExpoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./com/year3/distributedsystem/lecture4/corba/exponential/Expo.idl
* Friday, April 1, 2022 8:22:04 PM ICT
*/

public final class ExpoHolder implements org.omg.CORBA.portable.Streamable
{
  public Exponential.Expo value = null;

  public ExpoHolder ()
  {
  }

  public ExpoHolder (Exponential.Expo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Exponential.ExpoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Exponential.ExpoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Exponential.ExpoHelper.type ();
  }

}