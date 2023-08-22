package com.codingameproblem.workspace;

import com.codingameproblem.workspace.appConfig.ApplicationConfig;
import com.codingameproblem.workspace.commands.CommandInvoker;
import com.codingameproblem.workspace.exceptions.NoSuchCommandException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class CodingameproblemApplication {
	public static void main(String[] args) {
		//SpringApplication.run(CodingameproblemApplication.class, args);
		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
		String expectedSequence = "INPUT_FILE";
		String actualSequence = commandLineArgs.stream()
			.map(a -> a.split("=")[0])
			.collect(Collectors.joining("$"));
		if(expectedSequence.equals(actualSequence)){
			run(commandLineArgs);
		}
	}
	public static void run(List<String> commandLineArgs) {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
		BufferedReader reader;
		String inputFile = commandLineArgs.get(0).split("=")[1];
		commandLineArgs.remove(0);
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while (line != null) {
				List<String> tokens = Arrays.asList(line.split(" "));
				commandInvoker.executeCommand(tokens.get(0),tokens);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException | NoSuchCommandException e) {
			e.printStackTrace();
		}
	}
}
