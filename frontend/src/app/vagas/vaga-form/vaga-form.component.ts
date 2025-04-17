import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VagaService } from '../vaga.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-vaga-form',
  templateUrl: './vaga-form.component.html',
  styleUrls: ['./vaga-form.component.scss']
})
export class VagaFormComponent {
  form: FormGroup;
  isEdit = false;
  id?: number;

  constructor(
    private fb: FormBuilder,
    private vagaService: VagaService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.form = this.fb.group({
      titulo: ['', Validators.required],
      descricao: ['', Validators.required],
      requisitos: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    // this.id = Number(this.route.snapshot.paramMap.get('id'));
    // this.isEdit = !!this.id;

    // if (this.isEdit) {
    //   this.vagaService.buscarPorId(this.id!).subscribe(vaga => {
    //     this.form.patchValue(vaga);
    //   });
    // }
  }

  onSubmit() {
    if (this.form.invalid) return;

    const acao = this.isEdit
      ? this.vagaService.atualizar(this.id!, this.form.value)
      : this.vagaService.criar(this.form.value);

    acao.subscribe(() => this.router.navigate(['/vagas/admin']));
  }
}
