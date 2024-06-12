package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.demo.model.Statistics;

public class MainClass {

	static float mean = 0f;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//Input we can get it from CLI
		String s = in.nextLine();
		System.out.println("You entered string " + s);

//String Converted to List of Integer	    
		List<Integer> inputList = Arrays.asList(s.toString().split(",")).stream().map(r -> Integer.parseInt(r))
				.collect(Collectors.toList());
//Mean Calculation		
		float mean = getMeanValue(inputList) / inputList.size();
//Mean Output
		System.out.println("Mean: " + mean);

//Median Output		
		float median = (float) inputList.get(inputList.size() / 2);
		System.out.println("Median: " + median);

		Statistics statistics = new Statistics();
		statistics.setMean(mean);
		statistics.setMedian(median);

		saveToStaticsTable(statistics);

	}

	private static void saveToStaticsTable(Statistics statistics) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstm = null;
		int flag = 0;

		try {
			con = DBConnection.getDBConnection();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		if (Objects.nonNull(con)) {
			try {
				pstm = con.prepareStatement("insert into Statistics(mean,median) values (?,?)");
				pstm.setFloat(1, statistics.getMean());
				pstm.setFloat(2, statistics.getMedian());
				flag = pstm.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());

			}
		}

		if (flag > 0) {
			System.out.println("Data Saved");
		}

	}

	// Mean Calculation
	private static float getMeanValue(List<Integer> inputList) {
		mean = 0f;
		inputList.stream().forEach(r -> {
			mean = mean + r;
		});

		return mean;
	}

}
