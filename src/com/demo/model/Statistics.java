package com.demo.model;

public class Statistics {

	private int id;
	private float mean=0.0f;
	private float median=0.0f;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getMean() {
		return mean;
	}
	public void setMean(float mean) {
		this.mean = mean;
	}
	public float getMedian() {
		return median;
	}
	public void setMedian(float median) {
		this.median = median;
	}
	public Statistics(int id, float mean, float median) {
		super();
		this.id = id;
		this.mean = mean;
		this.median = median;
	}
	
	public Statistics() {
		
	}
	
	
}
