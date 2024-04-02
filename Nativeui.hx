package;

#if cpp
import cpp.Lib;
#elseif neko
import neko.Lib;
#end

#if (android)
import nme.JNI;
#end


class Nativeui {
	
	#if (android)
	public static function makeToast(msg:String):Void {
		_makeToast_func(msg);
	}
	
	public static function showProgressDialog(msg:String, cancelable:Bool = true ):Void 
	{
		_showProgressDialog_func( msg, cancelable);
	}
	
	public static function hideProgressDialog():Void 
	{
		_hideProgressDialog_func();
	}

	public static function openUrl(url:String):Void {
		_openUrl_func(url);
	}
	
	#end
	
	
	#if (android && openfl)
	private static var _openUrl_func = JNI.createStaticMethod("org.haxe.extension.Nativeui", "openUrl", "(Ljava/lang/String;)V");
	private static var _makeToast_func = JNI.createStaticMethod("org.haxe.extension.Nativeui", "makeToast", "(Ljava/lang/String;)V");
	private static var _showProgressDialog_func = JNI.createStaticMethod( "org.haxe.extension.Nativeui", "showProgressDialog", "(Ljava/lang/String;Z)V");
	private static var _hideProgressDialog_func = JNI.createStaticMethod("org.haxe.extension.Nativeui", "hideProgressDialog", "()V");
	#end
	
	
}