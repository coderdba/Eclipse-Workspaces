package com.gm.music;


public class NotesList {
	
	private NotesList() {} // prevent instantiation
	
	/* Notes frequencies reference
	 261 // c4 sa 
	 277 // c#4 r1
	 329 // e g3
	 349 // f m1
	 392 // g p
	 415 // g# d1
	 494 // b n3
	 523 // c5 s
	 */
	
	public static final float s2  = 261f;
	public static final float r12 = 277f;
	public static final float g32 = 329f;
	public static final float m12 = 349f;
	public static final float p2  = 392f;
	public static final float d12 = 415f;
	public static final float n32 = 494f;
	public static final float s3  = 523f;
	
	public static final float[] s = {130.8f, 261.6f, 523.3f}; // c4
	
	public static final float[] r1 = {138.6f, 277.2f, 554.4f}; // c#
	public static final float[] r2 = {146.8f, 293.7f, 587.3f}; // d
	public static final float[] r3 = {155.6f, 311.1f, 622.3f}; // eb
	
	public static final float[] g1 = {146.8f, 293.7f, 587.3f}; // d
	public static final float[] g2 = {155.6f, 311.1f, 622.3f}; // eb
	public static final float[] g3 = {164.8f, 329.6f, 659.3f}; // e
	
	public static final float[] m1 = {174.6f, 349.2f, 698.5f}; // f
	public static final float[] m2 = {185.0f, 370.0f, 740.0f}; // f#
	
	public static final float[] p = {196.0f, 392f, 784f}; // g
	
	public static final float[] d1 = {207.7f, 415.3f, 830.6f}; // g#
	public static final float[] d2 = {220.0f, 440.0f, 880.0f}; // a
	
	public static final float[] n1 = {220.0f, 440.0f, 880.0f}; // a
	public static final float[] n2 = {233.1f, 466.2f, 932.3f}; // bb
	public static final float[] n3 = {246.9f, 493.9f, 987.8f}; // b

}
