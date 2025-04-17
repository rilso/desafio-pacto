import { Component } from '@angular/core';
import { VagaService } from '../vaga.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vaga-admin',
  templateUrl: './vaga-admin.component.html',
  styleUrls: ['./vaga-admin.component.scss']
})
export class VagaAdminComponent {
  vagas: any[] = [];

  constructor(private vagaService: VagaService, private router: Router) {}

  ngOnInit(): void {
    // this.carregar();

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

  carregar() {
    this.vagaService.listar().subscribe(res => this.vagas = res);
  }

  editar(id: number) {
    this.router.navigate(['/vagas/editar', id]);
  }

  excluir(id: number) {
    if (confirm('Deseja realmente excluir esta vaga?')) {
      this.vagaService.excluir(id).subscribe(() => this.carregar());
    }
  }
}
