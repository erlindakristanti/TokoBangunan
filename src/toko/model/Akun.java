/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko.model;

/**
 *
 * @author Hp
 */
public class Akun {
    private int ID_Akun;
    private String Username;
    private String Password_2;

    public int getID_Akun() {
        return ID_Akun;
    }

    public void setID_Akun(int ID_Akun) {
        this.ID_Akun = ID_Akun;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword_2() {
        return Password_2;
    }

    public void setPassword_2(String Password_2) {
        this.Password_2 = Password_2;
    }
}
