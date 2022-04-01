package Exponential;


/**
* Exponential/ExpoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./com/year3/distributedsystem/lecture4/corba/exponential/Expo.idl
* Friday, April 1, 2022 8:22:04 PM ICT
*/

abstract public class ExpoHelper
{
  private static String  _id = "IDL:Exponential/Expo:1.0";

  public static void insert (org.omg.CORBA.Any a, Exponential.Expo that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Exponential.Expo extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Exponential.ExpoHelper.id (), "Expo");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Exponential.Expo read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ExpoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Exponential.Expo value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Exponential.Expo narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Exponential.Expo)
      return (Exponential.Expo)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Exponential._ExpoStub stub = new Exponential._ExpoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Exponential.Expo unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Exponential.Expo)
      return (Exponential.Expo)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Exponential._ExpoStub stub = new Exponential._ExpoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}