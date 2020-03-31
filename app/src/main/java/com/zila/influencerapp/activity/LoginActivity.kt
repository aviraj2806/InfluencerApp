package com.zila.influencerapp.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.cardview.widget.CardView
import com.zila.influencerapp.R

class LoginActivity : AppCompatActivity() {

    lateinit var etLoginUserId: EditText
    lateinit var etLoginPass: EditText
    lateinit var btnLogin: Button
    lateinit var txtRegister: TextView
    lateinit var txtForgotPass: TextView
    val validUser = "admin"
    val validPass = "admin"
    lateinit var shake: Animation
    lateinit var cardViewLogin: CardView
    lateinit var txtTitleLogin: TextView
    lateinit var imgLogoLogin: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etLoginUserId = findViewById(R.id.etLoginUserId)
        etLoginPass = findViewById(R.id.etLoginPass)
        btnLogin = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.txtRegister)
        txtForgotPass = findViewById(R.id.txtForgotPass)
        cardViewLogin = findViewById(R.id.cardViewLogin)
        imgLogoLogin = findViewById(R.id.imgLogoLogin)
        txtTitleLogin = findViewById(R.id.txtTitleLogin)
        shake = AnimationUtils.loadAnimation(this@LoginActivity, R.anim.shake)

        cardViewLogin.visibility = View.GONE
        imgLogoLogin.visibility = View.GONE
        txtTitleLogin.visibility = View.GONE

        txtRegister.clearAnimation()
        txtForgotPass.clearAnimation()
        txtForgotPass.startAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_in))
        txtRegister.startAnimation(AnimationUtils.loadAnimation(this,R.anim.push_right_in))
        cardViewLogin.clearAnimation()
        cardViewLogin.startAnimation(AnimationUtils.loadAnimation(this,R.anim.push_down_in))
        cardViewLogin.visibility = View.VISIBLE
        imgLogoLogin.clearAnimation()
        txtTitleLogin.clearAnimation()
        Handler().postDelayed(Runnable {
            imgLogoLogin.startAnimation(AnimationUtils.loadAnimation(this,R.anim.push_down_in))
            imgLogoLogin.visibility = View.VISIBLE
        },150)
        Handler().postDelayed(Runnable {
            txtTitleLogin.startAnimation(AnimationUtils.loadAnimation(this,R.anim.push_down_in))
            txtTitleLogin.visibility = View.VISIBLE
        },250)


        btnLogin.setOnClickListener(View.OnClickListener {
            val user = etLoginUserId.text.toString().trim()
            val pass = etLoginPass.text.toString().trim()
            etLoginPass.clearAnimation()
            etLoginUserId.clearAnimation()
            cardViewLogin.clearAnimation()

            if (user.isEmpty() || pass.isEmpty()) {
                makeToast("Please enter proper login credentials.")
                cardViewLogin.startAnimation(shake)
                etLoginUserId.clearFocus()
                etLoginPass.clearFocus()
            } else {
                if (user != validUser && pass == validPass) {
                    etLoginUserId.startAnimation(shake)
                    makeToast("Invalid User ID.")
                    etLoginUserId.text = null
                    etLoginUserId.hint = "Enter valid User ID"
                    etLoginUserId.setHintTextColor(resources.getColor(R.color.error))
                    etLoginUserId.clearFocus()
                    etLoginPass.clearFocus()
                }

                if (pass != validPass && user == validUser) {
                    etLoginPass.startAnimation(shake)
                    makeToast("Invalid Password.")
                    etLoginPass.text = null
                    etLoginPass.hint = "Enter valid Password"
                    etLoginPass.setHintTextColor(resources.getColor(R.color.error))
                    etLoginPass.clearFocus()
                    etLoginUserId.clearFocus()
                }

                if (pass != validPass && user != validUser) {
                    etLoginPass.startAnimation(shake)
                    etLoginUserId.startAnimation(shake)
                    makeToast("Invalid Credentials")
                    etLoginUserId.text = null
                    etLoginUserId.hint = "Enter valid User ID"
                    etLoginUserId.setHintTextColor(resources.getColor(R.color.error))
                    etLoginPass.text = null
                    etLoginPass.hint = "Enter valid Password"
                    etLoginPass.setHintTextColor(resources.getColor(R.color.error))
                    etLoginPass.clearFocus()
                    etLoginUserId.clearFocus()
                }

                if (user == validUser && pass == validPass) {
                    val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })

        txtForgotPass.setOnClickListener {
            makeToast("Feature Not Developed.")
        }

        txtRegister.setOnClickListener {
            makeToast("Feature Not Developed.")
        }
    }

    fun makeToast(text:String){
        val inflater: LayoutInflater = layoutInflater
        val root: View = inflater.inflate(R.layout.toast, null)
        val toast = Toast(this@LoginActivity)
        root.findViewById<TextView>(R.id.toast_text).text =
            text
        toast.view = root
        toast.duration = Toast.LENGTH_SHORT
        toast.show()
    }

}
