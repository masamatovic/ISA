package com.example.demo.model; /***********************************************************************
 * Module:  AdministratorKlinickogCentra.java
 * Author:  Korisnik
 * Purpose: Defines the Class AdministratorKlinickogCentra
 ***********************************************************************/

import java.util.*;

/** @pdOid 30ac365b-f456-4e53-a7b0-4b1e87fa2b47 */
public class AdministratorKlinickogCentra {
   /** @pdOid cf6e0e87-1a1f-4265-9f4d-ebf664f08566 */
   private Long id;
   /** @pdOid 6507aacc-45ba-4e53-9f5d-1e53dc8e3f16 */
   private String ime;
   /** @pdOid bb12f493-0926-46b0-b67d-e337bcb29ae3 */
   private String prezime;
   /** @pdOid e423a881-f6fa-4fd9-8c52-969fe57c92c1 */
   private String email;
   /** @pdOid 933ce6e6-480e-4c11-aa57-7f7c89d76dae */
   private String lozinka;
   /** @pdOid 78ae1831-1ba9-4c70-9227-64664fab622b */
   private String adresa;
   /** @pdOid 5dc281bf-6a72-404a-91c4-4e440f4c9077 */
   private String grad;
   /** @pdOid 9da9af60-defd-4797-b04e-d983cc7697bc */
   private String drzava;
   /** @pdOid 8bde1bc7-5dbf-4f5a-8be4-ac7f7a85e7e5 */
   private String telefon;
   /** @pdOid dcca9502-91db-4e20-975a-b17127bbe852 */
   private String jmbg;
   
   /** @pdRoleInfo migr=no name=ZahtevZaRegistraciju assc=association32 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<ZahtevZaRegistraciju> zahtevZaRegistraciju;
   
   
   /** @pdGenerated default getter */
   public java.util.List<ZahtevZaRegistraciju> getZahtevZaRegistraciju() {
      if (zahtevZaRegistraciju == null)
         zahtevZaRegistraciju = new java.util.ArrayList<ZahtevZaRegistraciju>();
      return zahtevZaRegistraciju;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorZahtevZaRegistraciju() {
      if (zahtevZaRegistraciju == null)
         zahtevZaRegistraciju = new java.util.ArrayList<ZahtevZaRegistraciju>();
      return zahtevZaRegistraciju.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newZahtevZaRegistraciju */
   public void setZahtevZaRegistraciju(java.util.List<ZahtevZaRegistraciju> newZahtevZaRegistraciju) {
      removeAllZahtevZaRegistraciju();
      for (java.util.Iterator iter = newZahtevZaRegistraciju.iterator(); iter.hasNext();)
         addZahtevZaRegistraciju((ZahtevZaRegistraciju)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newZahtevZaRegistraciju */
   public void addZahtevZaRegistraciju(ZahtevZaRegistraciju newZahtevZaRegistraciju) {
      if (newZahtevZaRegistraciju == null)
         return;
      if (this.zahtevZaRegistraciju == null)
         this.zahtevZaRegistraciju = new java.util.ArrayList<ZahtevZaRegistraciju>();
      if (!this.zahtevZaRegistraciju.contains(newZahtevZaRegistraciju))
         this.zahtevZaRegistraciju.add(newZahtevZaRegistraciju);
   }
   
   /** @pdGenerated default remove
     * @param oldZahtevZaRegistraciju */
   public void removeZahtevZaRegistraciju(ZahtevZaRegistraciju oldZahtevZaRegistraciju) {
      if (oldZahtevZaRegistraciju == null)
         return;
      if (this.zahtevZaRegistraciju != null)
         if (this.zahtevZaRegistraciju.contains(oldZahtevZaRegistraciju))
            this.zahtevZaRegistraciju.remove(oldZahtevZaRegistraciju);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllZahtevZaRegistraciju() {
      if (zahtevZaRegistraciju != null)
         zahtevZaRegistraciju.clear();
   }

}