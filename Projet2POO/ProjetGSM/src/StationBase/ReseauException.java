/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationBase;

/**
 *
 * @author MAKOUGOUM
 */

   /**
 * Exception personnalisée pour les erreurs liées au réseau GSM.
 */
public class ReseauException extends Exception {

    public ReseauException(String message) {
        super(message);
    }

    public ReseauException(String message, Throwable cause) {
        super(message, cause);
    }
}
 

