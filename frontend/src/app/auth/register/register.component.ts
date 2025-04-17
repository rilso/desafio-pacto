import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  form: FormGroup;
  sucesso = false;
  erro = '';

  constructor(
    private fb: FormBuilder,
    private auth: AuthService,
    private router: Router
  ) {
    this.form = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.minLength(3)]],
    });
  }

  onSubmit() {
    if (this.form.invalid) return;

    this.auth.register(this.form.value).subscribe({
      next: () => {
        this.sucesso = true;
        this.erro = '';
        setTimeout(() => this.router.navigate(['/login']), 1500);
      },
      error: () => this.erro = 'Erro ao registrar usuário.'
    });
  }
}
