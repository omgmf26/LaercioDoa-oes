package com.example.doacoes;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyRequestQueue {

    public  static final String TAG = VolleyRequestQueue.class.getSimpleName();

    private static  VolleyRequestQueue instance;
    private RequestQueue requestQueue;
    private static Context ctx;


    private VolleyRequestQueue(Context context) {

        ctx = context;

    }

    public static synchronized  VolleyRequestQueue getInstance(Context context){
        if(instance == null)
            instance = new VolleyRequestQueue(context);

        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
                    return requestQueue;
    }

    public <T> void addToRequestQueue(Object tag, Request<T> req) {
        req.setTag(TAG)
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        addToRequestQueue(TAG, req);
    }

    public void cancelRequest () {
        cancelRequest(TAG);
    }

    public void cancelRequest (Object tag) {

        if(requestQueue != null)
            requestQueue.cancelAll(tag);
    }

}
