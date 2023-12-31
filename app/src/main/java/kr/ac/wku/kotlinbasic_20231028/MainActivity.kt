package kr.ac.wku.kotlinbasic_20231028

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.ac.wku.kotlinbasic_20231028.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.btnLog.setOnClickListener {

//             로그 버튼이 클릭되면 실행될 코드 스코프


//            로그 찍어보기
            Log.d("메인화면", "로그 버튼 클릭됨")  // debug 용 로그 (개발자 편의용)
            Log.e("메인화면", "e로 로그 찍어보기") // error 감지 로그
            Log.wtf("메인화면", "wtf로 로그 찍어보기") // 일종의 에러 로그 (분노 표출)


        }

        binding.btnToast.setOnClickListener {

            // 토스트 버튼이 클릭되면 => 토스트 띄우기

            Toast.makeText(this, "토스트 클릭됨", Toast.LENGTH_SHORT).show()

        }

        binding.btnVariable.setOnClickListener {

            // 코틀린 변수 문법 연습

            // 내 이름 저장할 변수 (String) 생성 => 변동 가능성 있다

            var myName : String

            // 내 이름을 저장

            myName = "조경진"

            // 이름 변경 => 진경조 (역순)  =>  var로 변수를 선언했기 때문에 가능.
            
            myName = "진경조"

            Toast.makeText(this, myName, Toast.LENGTH_SHORT).show()  // 진경조 문구 토스트


            // 어머니 이름 : 변경 불가  =>  JAVA의 final

            val motherName : String
            motherName = "어머니"

            // 어머니 이름 변경 시도
            // motherName = "어머니2"  // syntax 에러 발생! => 상수로 선언한 공간의 값을 변경 시도 :


//            내 출생년도 var에 저장. (변경 가능) => 변수 생성과 동시에 저장
            var myBirthYear = 1988   // 자료형이 자동으로 Int로 추론되어 결정됨. (자료형 고정됨. 다른 종류의 값 대입 불가)

            // 코틀린에서는 모든 변수가 전부 .메쏘드 등 활용 가능 (전부 참조형)
            // myBirthYear.compareTo()  => Int도 참조형. 추가 기능 활용 가능

        }


        binding.btnCondition.setOnClickListener {

            // 사용자의 나이를 val에 저장 => EditText를 통해서 입력 받자.

            // EditText는 .toString()으로 String입력값을 받아오는 역할.
            // Int로 변환 => Casting 필요  =>  String변수.toInt() 실행

            val userAge = binding.edtUserAge.text.toString().toInt()

            // 20살 이상? "성인" 문구 토스트로

//            if (userAge >= 20) {
//                Toast.makeText(this, "성인입니다.", Toast.LENGTH_SHORT).show()
//            }
//            else if (userAge >= 17) {
//                Toast.makeText(this, "고등학생입니다.", Toast.LENGTH_SHORT).show()
//            }
//            else {
//                Toast.makeText(this, "중학생 또는 그 이하 입니다.", Toast.LENGTH_SHORT).show()
//            }

//            when 활용 예시
            when (userAge) {
                25 -> {
                    // userAge에 25가 들어있을때 실행할 코드
                    Toast.makeText(this, "25살 입니다.", Toast.LENGTH_SHORT).show()
                }
                27, 28, 29 -> {
                    // userAge의 값이 27, 28, 29 셋중 하나라면 실행
                    Toast.makeText(this, "20대 후반입니다.", Toast.LENGTH_SHORT).show()
                }
                in 30..39 -> {
                    // userAge의 값이 30 이상 39 이하인 경우
                    Toast.makeText(this, "30대 입니다.", Toast.LENGTH_SHORT).show()
                }
            }



        }

        binding.btnNameToast.setOnClickListener {

            // 이름 입력칸에 적힌 이름을 그대로 토스트로 출력 (연습)

            val inputName = binding.edtName.text.toString()

            // Toast.makeText(this, inputName, Toast.LENGTH_SHORT).show()

            // 이름 입력칸에 적힌 이름 + "님 환영합니다." 토스트로 출력 (응용)
            // 조경진 => "조경진님 환영합니다." 토스트

            Toast.makeText(this, "${inputName}님 환영합니다.", Toast.LENGTH_SHORT).show()

        }

    }
}