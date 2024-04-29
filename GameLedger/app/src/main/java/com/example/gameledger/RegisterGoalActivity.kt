package com.example.gameledger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gameledger.databinding.ActivityRegisterGoalBinding
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class RegisterGoalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterGoalBinding
    private lateinit var userService: UserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterGoalBinding.inflate(layoutInflater)
        userService = RetrofitClient.retrofit.create(UserService::class.java)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.registerButton.setOnClickListener {
            val goalName = binding.goalNameInput.text.toString()
            val goalValue = Integer.parseInt(binding.goalValueInput.text.toString())
            val foodValue = Integer.parseInt(binding.foodValueInput.text.toString())
            val trafficValue = Integer.parseInt(binding.trafficValueInput.text.toString())
            val cultureValue = Integer.parseInt(binding.cultureValueInput.text.toString())
            val lifeValue = Integer.parseInt(binding.lifeValueInput.text.toString())

            userService.signupInputData(goalName, goalValue, foodValue, trafficValue, cultureValue, lifeValue)
                .enqueue(object : retrofit2.Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>,
                        response: Response<ResponseBody>
                    ) {
                        if (response.isSuccessful) {
                            Log.e(
                                "API Call",
                                "Successful response: ${response.code()}"
                            )
                            var intent = Intent(
                                this@RegisterGoalActivity,
                                LoginActivity::class.java
                            )
                            startActivity(intent)
                        } else {
                            Log.e(
                                "API Call",
                                "Unsuccessful response: ${response.code()}"
                            )
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        Log.e("API Call", "Failed to make API call: ${t.message}", t)
                    }
                })
        }
    }


}