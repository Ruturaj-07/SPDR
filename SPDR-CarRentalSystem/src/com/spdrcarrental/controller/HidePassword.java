//package com.spdrcarrental.controller;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//
//public class HidePassword extends Thread {
//  boolean stopThread = false;
//  boolean hideInput = false;
//  boolean shortMomentGone = false;
//
//  public void run() {
//    try {
//      sleep( 50 );
//    }
//    catch( InterruptedException e ) {
//    }
//    shortMomentGone = true;
//    while( !stopThread ) {
//      if( hideInput ) {
//        System.out.print( "\b*" );
//      }
//      try {
//        sleep( 1 );
//      }
//      catch( InterruptedException e ) {
//      }
//    }
//  }
//}
