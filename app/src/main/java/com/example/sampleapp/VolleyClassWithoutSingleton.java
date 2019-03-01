package com.example.sampleapp;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyClassWithoutSingleton {

    //  https://www.itsalif.info/content/android-volley-tutorial-http-get-post-put

        void getRequest(){

      //      RequestQueue requestQueue = Volley.newRequestQueue(this);
            final String url = "http://httpbin.org/get?param1=hello";

            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response) {
                            // display response
                            Log.d("Response", response.toString());
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.getMessage());
                        }
                    }
            );

// add it to the RequestQueue
          //  queue.add(getRequest);
        }


        void postRequest(){

            //      RequestQueue requestQueue = Volley.newRequestQueue(this);
           String  url = "http://httpbin.org/post";
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("Error.Response",error.getMessage());
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("name", "Alif");
                    params.put("domain", "http://itsalif.info");

                    return params;
                }
            };
          //  queue.add(postRequest);
        }

}
