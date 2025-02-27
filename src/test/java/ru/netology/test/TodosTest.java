package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;

 class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Овощи", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Во вторник после обед",
            "Приложение НетоБанка"
    );

    @Test
     void shouldAddThreeTasksOfDifferentType() {

        Todos todos = new Todos();

        todos.add(simpleTask,epic,meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTest() {

        Todos todos = new Todos();

        todos.add(simpleTask,epic,meeting);

        Task[] actual = todos.search("Молоко");
        Task[] expected = {epic};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
     void searchTest2() {

        Todos todos = new Todos();

        todos.add(simpleTask,epic,meeting);

        Task[] actual = todos.search("Позвонить");
        Task[] expected = {simpleTask};
        Assertions.assertArrayEquals(actual, expected);
}

    @Test
     void searchTest3() {

        Todos todos = new Todos();

        todos.add(simpleTask,epic,meeting);

        Task[] actual = todos.search("НетоБанка");
        Task[] expected = {meeting};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
     void searchTest4() {

        Todos todos = new Todos();

        todos.add(simpleTask,epic,meeting);

        Task[] actual = todos.search("о");
        Task[] expected = {simpleTask, epic, meeting};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
     void searchTest5() {

        Todos todos = new Todos();

        todos.add(simpleTask,epic,meeting);

        Task[] actual = todos.search("Багет");
        Task[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }
    }