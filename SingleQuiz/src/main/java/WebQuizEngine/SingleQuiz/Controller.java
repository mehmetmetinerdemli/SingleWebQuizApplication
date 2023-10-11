package WebQuizEngine.SingleQuiz;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class Controller {


    @GetMapping("/api/quiz")
    public Quiz getQuiz() {
        return quiz;
    }

    private final Quiz quiz = new Quiz("The Java Logo",
            "What is depicted on the Java logo?",
            new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"},
            2);

    private final Answer correctAnswer = new Answer(true, "Congratulations, you're right!");
    private final Answer incorrectAnswer = new Answer(false, "Wrong answer! Please, try again.");


    @PostMapping("/api/quiz")
    public Answer validateQuiz(@RequestParam("answer") int answer) {
        if(Objects.equals(answer,quiz.correctIndex())){
            return correctAnswer;
        }else{
            return incorrectAnswer;
        }

    }


}
