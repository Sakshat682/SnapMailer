package com.asher.snapmailer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailActivity extends Activity{

    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    private FloatingActionButton fab;

    final private Context context = this;

    private Button buttonSend;
    public void sendMail(String recepient, String sender, String Password) throws Exception{
        System.out.println("Message in process");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        Session session= Session.getDefaultInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, Password);
            }
        });
        Message message = prepareMessage(session, sender, recepient);
        Transport.send(message);
        System.out.println("Message finally sent");


    }
    private Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));

            String subject = this.editTextSubject.getText().toString();
            message.setSubject(subject);

            String msg = this.editTextMessage.getText().toString();
            message.setText(msg);
            return message;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_send_mail);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
            editTextEmail = (EditText) findViewById(R.id.editTextEmail);
            editTextMessage = (EditText) findViewById(R.id.editTextMessage);
            editTextSubject = (EditText) findViewById(R.id.editTextSubject);

            buttonSend = (Button) findViewById(R.id.buttonSend);
            buttonSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
                    String email = editTextEmail.getText().toString();
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.example.send_email.sharedpreferences",Context.MODE_PRIVATE);
                    String sender = sharedPreferences.getString("email","sorry");
                    String password = sharedPreferences.getString("password","nothere");


//                try {
////                SendMail sm = new SendMail(getApplicationContext(), email, subject, message);
////
////        sm.execute();
//                    GMailSender sender = new GMailSender("btech10614.19@bitmesra.ac.in", "PR@H@NJ@L7668905445a");
//                    sender.sendMail(subject,
//                            message,
//                            "btech10614.19@bitmesra.ac.in",
//                            email);
//                }
//                catch (Exception e){
//                    Log.e("SendMail", e.getMessage(), e);
//                }
                    try {
                        sendMail(email, sender, password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(SendMailActivity.this, FeatureActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            });

        }

        Button fbtn= findViewById(R.id.schedulefab);
        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SendMailActivity.this, SchedulingActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

    }

//    private void sendEmail(){
//        String email = editTextEmail.getText().toString();
//        String subject = editTextSubject.getText().toString();
//        String message = editTextMessage.getText().toString();
//
//        try {
////        SendMail sm = new SendMail(this, email, subject, message);
////
////        sm.execute();
//            GMailSender sender = new GMailSender(email, "PR@H@NJ@L7668905445a");
//            sender.sendMail(subject,
//                    message,
//                    "btech10614.19@bitmesra.ac.in",
//                    email);
//        }
//        catch (Exception e){
//            Log.e("SendMail", e.getMessage(), e);
//        }
//    }




}