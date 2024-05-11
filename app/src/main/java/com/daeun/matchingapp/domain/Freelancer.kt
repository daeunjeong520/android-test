package com.daeun.matchingapp.domain

data class Freelancer(
    val name: String,           // 프리랜서 이름
    val workStyle: String,      // 원격/상주
    val job: String,            // 직무
    val careerYear: String      // 경력기간
)
