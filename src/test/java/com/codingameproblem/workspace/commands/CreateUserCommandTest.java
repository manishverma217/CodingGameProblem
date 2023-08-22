package com.codingameproblem.workspace.commands;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import com.codingameproblem.workspace.entities.User;
import com.codingameproblem.workspace.services.IUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("CreateUserCommandTest")
@ExtendWith(MockitoExtension.class)
public class CreateUserCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    IUserService userServiceMock;

    @InjectMocks
    CreateUserCommand createUserCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("execute method of CreateUserCommand Should Print newly Created User To Console")
    public void execute_ShouldPrintQuestion() {
        //Arrange
        String expectedOutput = "User [id=1, contests=[], name=name, score=0]";
        User user = new User("1","name",0);
        when(userServiceMock.create("name")).thenReturn(user);

        //Act
        createUserCommand.execute(Arrays.asList("CREATE-USER", "name"));

        //Assert
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());

        verify(userServiceMock,times(1)).create(anyString());
    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}

