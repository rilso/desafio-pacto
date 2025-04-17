import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';
import { Usuario } from 'src/app/core/model/usuario.model';
import { TokenService } from '../token/token.service';
import { Role } from 'src/app/core/model/enum/Role';
import { RedirectService } from '../redirect/redirect.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  form: FormGroup;
  error: string = '';
  usuario: Usuario = new Usuario();

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private auth: AuthService,
    private tokenService: TokenService,
    private redirectService: RedirectService,
    private snackBar: MatSnackBar
  ) {
    this.form = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required]]
    });
  }

  onSubmit() {
    if (this.form.invalid) return;

    this.router.navigate(['/vagas'])
    // this.preecheLogin();

    // this.auth.login(this.usuario).subscribe((res: any) => {
    //   console.log('antes');
    //   if(res != null && res != undefined) {

    //     if(res.token != null && res.token != undefined && res.token.length != 0
    //         && res.userId != null && res.userId != undefined && res.userId.length != 0){
    //       console.log('entrei');

    //       this.tokenService.setToken(res.token);
    //       this.tokenService.setUID(res.userId);

    //       const role = this.tokenService.getTokenRole();

    //       if(role == Role.ADMIN) {
    //         this.redirectService.redirect('vagas');
    //       }else if(role == Role.COLABORADOR){
    //         this.redirectService.redirect('vagas');
    //       }else{
    //         this.redirectService.redirect('unauthorized');
    //       }

    //       this.snackBar.open('Login realizado!', undefined, {duration:1500});
    //     }
    //   }
    // }, error => {this.snackBar.open(error, undefined, {duration:3000})});
  }

  private preecheLogin() {
    this.usuario.email = this.form.get('email')?.value ?? '';
    this.usuario.password = this.form.get('senha')?.value ?? '';
  }
}
