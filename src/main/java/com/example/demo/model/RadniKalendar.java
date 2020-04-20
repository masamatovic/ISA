package com.example.demo.model;

/** Radni kalendar medicinskog osoblja
 * 
 * 
 * @pdOid 2c386778-bac0-47e5-adf5-996fd4e04896 */
public class RadniKalendar {
   /** @pdOid 9ea9fb90-75c2-4cca-8a1b-e745e688663d */
   private Long id;
   
   /** @pdRoleInfo migr=no name=AdministratorKlinike assc=association39 mult=1..1 */
   public AdministratorKlinike administratorKlinike;

}