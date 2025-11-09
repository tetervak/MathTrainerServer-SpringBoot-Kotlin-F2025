package ca.tetervak.mathtrainer.service

import ca.tetervak.mathtrainer.data.factory.AlgebraProblemFactory
import ca.tetervak.mathtrainer.domain.model.AlgebraProblem

import org.springframework.stereotype.Service

@Service
class RandomQuizService(
    private val problemFactory: AlgebraProblemFactory
) {

    private fun getRandomProblemList(numberOfProblems: Int):List<RemoteProblem> =
        List(size = numberOfProblems) { index ->
            val problem: AlgebraProblem = problemFactory.createRandomProblem()
            RemoteProblem(
                id = index + 1,
                text = problem.text,
                answer = problem.answer
            )
        }

    fun getRandomQuiz(numberOfProblems: Int): RemoteQuiz =
        RemoteQuiz(
            numberOfProblems = numberOfProblems,
            problems = getRandomProblemList(numberOfProblems)
        )
}