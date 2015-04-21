/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.KatalogÜrünleri.Servlets;

import com.KatalogÜrünleri.Entidades.Usuario;
import com.KatalogÜrünleri.Negocio.UsuarioN;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Familia
 */
public class CorreoServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mail= request.getParameter("txtemail");
        String targetPage = "./Principal.jsp";
        request.setAttribute("target", "./FPrincipal.jsp");
        request.setAttribute("targetModulo", "./FEnvioEmail.jsp");
        /*-------Para el envio de mails */
        UsuarioN un = new UsuarioN();
        Usuario entU = new Usuario();
        String men = "";
         request.setAttribute("mensaje",null); 
        
        
        String from = "soportekatalogurunleri@gmail.com";
        String to = mail;
        String subject = "Recordatorio Clave";
        String message ="";
       
        String login = "soportekatalogurunleri@gmail.com";
        String password = "AdminKat123";
        
        
        
        if ("Listar".equals(request.getParameter("action"))) {
            try {
         
            } catch (Exception ex) {
                Logger.getLogger(CorreoServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
            }
        }




        if ("envio".equals(request.getParameter("action"))) {
          
            try {
                 entU = un.getUsuarioEmail(mail); 
                 if(!entU.getUsuario().equals("0")){
                       message="\n Usuario: "+entU.getUsuario(); //SE ESTÁ LLAMANDO LO QUE VA A LLEGAR AL CORREO ELECTRÓNICO
                       message+="\n Contraseña: "+entU.getClave()+"\n RECUERDE CAMBIARLA";
                       men=message;
      // cuerpo del mensaje
                       
                       
                  men="Los datos han sido enviados  su correo";
                 }else{
                   men="Error El Correo \n no está registrado";
                 message="";
                 }


                /*Enviar mail por correo por gmail*/
                try {
                     if(!message.equals("")){ 
                    Properties props = new Properties();
                    props.setProperty("mail.host", "smtp.gmail.com");//servidor de salidas de gmail
                    props.setProperty("mail.smtp.port", "587");//puerto de salida
                    props.setProperty("mail.smtp.auth", "true");//autorización
                    props.setProperty("mail.smtp.starttls.enable", "true");//párametros-++0

                    Authenticator auth = new SMTPAuthenticator(login, password);

                    Session session = Session.getInstance(props, auth);

                    MimeMessage msg = new MimeMessage(session);
                    msg.setText(message);
                    msg.setSubject(subject);
                    msg.setFrom(new InternetAddress(from));
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    Transport.send(msg);
                     }  
                } catch (AuthenticationFailedException ex) {
                    men += "<br>Error de autenticacion"+ex.getCause();
                } catch (AddressException ex) {
                    men += "<br>Error Email del Usuario";
                } catch (MessagingException ex) {
                    men += "<br>Error al envío de datos de Usuario ";

                }

            } catch (Exception ex1) {
                Logger.getLogger(CorreoServlet.class.getName()).log(Level.SEVERE, null, ex1);
                  men=""+ ex1.getMessage();
            }
            request.setAttribute("mensaje", men);
        }
        if ("nuevo".equals(request.getParameter("action"))) {

            try {
            } catch (Exception ex) {
                Logger.getLogger(CorreoServlet.class.getName()).log(Level.SEVERE, null, ex);
                men=""+ ex.getMessage();
            }
        }
        

    request.setAttribute("mensaje",men+ ""+ mail);
    request.getRequestDispatcher("FEnvioEmail.jsp").forward(request, response);
 }
    
    private class SMTPAuthenticator extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}


