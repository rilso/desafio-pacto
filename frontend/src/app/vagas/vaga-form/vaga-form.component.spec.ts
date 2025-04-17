import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VagaFormComponent } from './vaga-form.component';

describe('VagaFormComponent', () => {
  let component: VagaFormComponent;
  let fixture: ComponentFixture<VagaFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VagaFormComponent]
    });
    fixture = TestBed.createComponent(VagaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
