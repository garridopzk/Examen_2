package com.example.examen_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private EditText usernameInput, passwordInput, ageInput;
    private RadioGroup genderRadioGroup;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Inicializar vistas
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        ageInput = findViewById(R.id.age_input);
        genderRadioGroup = findViewById(R.id.gender_radio_group);
        registerButton = findViewById(R.id.register_button);

        // Configurar el listener para el botón de registro
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegistration();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class );
                startActivity(intent);
            }
        });
    }

    private void handleRegistration() {
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        String ageStr = ageInput.getText().toString();

        if (username.isEmpty() || password.isEmpty() || ageStr.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);

        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Por favor, seleccione su género", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
        String gender = selectedGenderRadioButton.getText().toString();

        // Aquí puedes agregar la lógica para registrar al usuario, por ejemplo:
        // Guardar datos en una base de datos, enviar a un servidor, etc.

        // Mostrar un mensaje de éxito
        String message = "Registro exitoso\nUsuario: " + username + "\nEdad: " + age + "\nGénero: " + gender;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        // Redirigir a otra actividad si es necesario
        // Intent intent = new Intent(RegistrationActivity.this, OtraActividad.class);
        // startActivity(intent);
        // finish();
    }
}

