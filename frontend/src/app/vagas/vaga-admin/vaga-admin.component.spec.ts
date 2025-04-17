import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VagaAdminComponent } from './vaga-admin.component';

describe('VagaAdminComponent', () => {
  let component: VagaAdminComponent;
  let fixture: ComponentFixture<VagaAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VagaAdminComponent]
    });
    fixture = TestBed.createComponent(VagaAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
