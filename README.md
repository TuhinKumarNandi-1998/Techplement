# Quiz Generator

This project implements a simple Quiz Generator. User(who has ADMIN role) can add Quiz Questions and options. Any user can take the quiz game. The game is designed using the MVC (Model-View-Controller) architecture.

## Project Structure

- **Model**
  - `Questions.java` : Represents Question model which has the id, question text, list of options and the correct option.
  - `Options.java`: Represents Option model which has the id, option, question_id(which question's option), sequence(like a, b, c, d).
  - `Users.java` : Represents User model which has information about user its roles.
  - `Roles.java`: Represents Roles model which has id and roleName.

- **Controller**
    - `QuestionAddAndRemoveController.java`: Takes input related to adding or removing of questions from the main via DTO and forward it to the relevant method in QuestionAddAndRemoveService.
    - `UserController.java`: Takes input related to adding or removing users from the main via DTO and forward it to the UserService.
    - `QuizPlayController.java` : Takes input related to the play of the quiz from the main and forward the request to the QuizPlayService.

- **Service**
    - `QuestionAddAndRemoveService.java`: Manages the question addition and question removal logic.
    - `UserService.java`: Manages the user add and removal logic.
    - `QuizPlayService.java`: Manages the quiz generator logic.

- **Repositories**
    - `QuestionsRepository.java`: Map is used as a in-memory DB to store Questions model information. Here, saving to the DB, removing from the DB and retrieving from the DB is done.
    - `OptionsRepository.java`: Map is used as a in-memory DB to store Options model information. Here, saving to the DB and retrieving from the DB is done.
    - `UserRepository.java`: Map is used as a in-memory DB to store Users model information. Here, saving to the DB, removing from the DB and retrieving from the DB is done.
    - `RolesRepository.java`: Map is used as a in-memory DB to store Roles model information. Here, saving to the DB and retrieving from the DB is done.


- **Main**
    - `Main.java`: Sets up the game, instantiate the Models, Controller, Service, Repositories and starts it. Added some questions by harding coding, user can also add questions and play the quiz.


## Requirements

- Java 8 or higher