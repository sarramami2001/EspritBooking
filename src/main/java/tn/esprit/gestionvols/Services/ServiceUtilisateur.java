package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.SQLDataAccess.DAOUtilisateur;
import tn.esprit.gestionvols.Models.Utilisateur;
import tn.esprit.gestionvols.Utilities.Role;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.List;

public class ServiceUtilisateur {
    private DAOUtilisateur service = new DAOUtilisateur();
    private Utilisateur utilisateur = new Utilisateur("haboubi", "yosra", "yosra@gmail.com", "07234926", "783094I095809H",55990847, Role.Administrateur);

    private static final String key = "1234567812345678"; 

    public static String encrypt(String input) {
        try {
            // Créer une instance de chiffreur AES
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // Créer une clé secrète AES
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            // Initialiser le chiffreur en mode de chiffrement avec la clé
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // Chiffrer le texte d'entrée
            byte[] encryptedBytes = cipher.doFinal(input.getBytes());
            // Convertir les bytes chiffrés en une représentation Base64
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String encryptedText) {
        try {
            // Créer une instance de Cipher pour AES
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // Créer une clé secrète AES
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            // Initialiser le Cipher en mode déchiffrement avec la clé
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // Déchiffrer les données
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            // Retourner le texte déchiffré
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void ajouter() {

        utilisateur.setCin(encrypt(utilisateur.getCin()));
        utilisateur.setNumPasseport(encrypt(utilisateur.getNumPasseport()));
        service.create(utilisateur);
        }
    public void SupprimerUtilisateur(int id){
        service.delete(id);
    }
    public List<Utilisateur> AfficherUtilisateurs(){
        return service.getAll();
    }

    public Utilisateur AfficherUtilisateurById(int id){
        Utilisateur u=service.getById(id);
        u.setCin(decrypt(u.getCin()));
        u.setNumPasseport(decrypt(u.getNumPasseport()));
        return u;
    }

    public void ModifierUtilisateur(Utilisateur utilisateur){
        service.update(utilisateur);
    }

}
