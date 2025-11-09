package ca.tetervak.mathtrainer.service

import com.fasterxml.jackson.annotation.JsonProperty

data class RemoteQuiz(
    @field:JsonProperty("number_of_problems")
    val numberOfProblems: Int,
    val problems: List<RemoteProblem>
)
