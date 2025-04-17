import { Component } from '@angular/core';
import { VagaService } from '../vaga.service';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-vaga-list',
  templateUrl: './vaga-list.component.html',
  styleUrls: ['./vaga-list.component.scss']
})
export class VagaListComponent {
  vagas: any[] = [];

  constructor(private vagaService: VagaService, private auth: AuthService) {}

  ngOnInit(): void {
    // this.vagaService.listar().subscribe((res) => {
    //   this.vagas = res;
    // });

    this.vagas = [
      {
        titulo: 'Desenvolvedor Full Stack',
        descricao: 'Atuar no desenvolvimento de aplicações web usando Angular e Spring Boot.',
        requisitos: 'Angular, TypeScript, Java, Spring Boot, REST APIs'
      },
      {
        titulo: 'Analista de QA',
        descricao: 'Responsável por criar e executar testes automatizados.',
        requisitos: 'Selenium, Postman, JUnit, Git'
      },
      {
        titulo: 'Product Owner',
        descricao: 'Gerenciar backlog e definir prioridades para o time de desenvolvimento.',
        requisitos: 'Scrum, Kanban, Comunicação, Visão de Produto'
      }
    ];
  }

  // candidatar(id: number) {
  //   this.vagaService.candidatar(id).subscribe(() => {
  //     alert('Candidatura realizada com sucesso!');
  //   });
  // }
}
