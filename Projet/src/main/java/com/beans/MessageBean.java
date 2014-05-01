package com.beans;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller( "messageBean" )
@Scope( "session" )
public class MessageBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            value;
    private String            emailClient;
    private String            emailProprieatire;
    private String            resultatEnvoie;

    public MessageBean() {
        super();
    }

    public void message() {
        if ( emailProprieatire.equals( "" ) || ( emailProprieatire.length() == 0 ) ) {
            resultatEnvoie = "Envoie n'est pas reussi, veuillez saisir des adresse correct ";
        } else {
            System.out.println( "email Client : " + emailClient );
            System.out.println( "email Prop : " + emailProprieatire );
            final String username = "tafni.amar@gmail.com";
            final String password = "wxcvbn12";

            Properties props = new Properties();
            props.put( "mail.smtp.auth", "true" );
            props.put( "mail.smtp.starttls.enable", "true" );
            props.put( "mail.smtp.host", "smtp.gmail.com" );
            props.put( "mail.smtp.port", "587" );

            Session session = Session.getInstance( props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication( username, password );
                        }
                    } );

            try {

                Message message = new MimeMessage( session );
                message.setFrom( new InternetAddress( "tafni.amar@gmail.com" ) );
                message.setRecipients( Message.RecipientType.TO,
                        InternetAddress.parse( emailProprieatire ) );
                message.setSubject( "Contact a propos de votre appartement  par ce Client " + getEmailClient() );
                message.setText( "Dear Mail Crawler,"
                        + getValue() );

                Transport.send( message );

                System.out.println( "Done" );
                resultatEnvoie = "Envoie est bien Reussi";

            } catch ( MessagingException e ) {

                throw new RuntimeException( e );

            }
        }
    }

    /********************************************************************/
    /* Getter and Setter */
    public void setValue( String value ) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient( String emailClient ) {
        this.emailClient = emailClient;
    }

    public String getEmailProprieatire() {
        return emailProprieatire;
    }

    public void setEmailProprieatire( String emailProprieatire ) {
        this.emailProprieatire = emailProprieatire;
    }

    public String getResultatEnvoie() {
        return resultatEnvoie;
    }

    public void setResultatEnvoie( String resultatEnvoie ) {
        this.resultatEnvoie = resultatEnvoie;
    }

}
