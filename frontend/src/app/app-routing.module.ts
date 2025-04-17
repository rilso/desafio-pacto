import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { VagaListComponent } from './vagas/vaga-list/vaga-list.component';
import { VagaAdminComponent } from './vagas/vaga-admin/vaga-admin.component';
import { VagaFormComponent } from './vagas/vaga-form/vaga-form.component';


const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'registrar', component: RegisterComponent },
  { path: 'vagas', component: VagaListComponent },
  { path: 'vagas/admin', component: VagaAdminComponent, },
  { path: 'vagas/nova', component: VagaFormComponent, },
  { path: 'vagas/editar/:id', component: VagaFormComponent, }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
