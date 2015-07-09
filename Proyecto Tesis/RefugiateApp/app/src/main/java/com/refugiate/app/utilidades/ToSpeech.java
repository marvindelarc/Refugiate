package com.refugiate.app.utilidades;

import java.util.Locale;


import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

public class ToSpeech {

	public TextToSpeech tts;
	private String mensaje="";
	private Context context;
	public  ToSpeech(Context context, String mensaje){
		this.context=context;
		this.mensaje=mensaje;
		init();
		
	}
		
	public void init()
	{
		//if(gipUsuarioDAO.Buscar(context,1).isVoz()) {
			tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {

				public void onInit(int status) {
					if (status == TextToSpeech.SUCCESS) {
						int result = tts.isLanguageAvailable(Locale.getDefault());
						if (result == TextToSpeech.LANG_MISSING_DATA
								|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
							Log.e("TTS", "Language is not supported");
						}
						speak();

						} else {
							Log.e("TTS", "Initilization Failed");
						}


					}
				}
			);
		//}
		
	}
	private void speak() {
		tts.speak(mensaje, TextToSpeech.QUEUE_FLUSH, null);
		//tts.stop();
		//tts.shutdown();
	}
}
