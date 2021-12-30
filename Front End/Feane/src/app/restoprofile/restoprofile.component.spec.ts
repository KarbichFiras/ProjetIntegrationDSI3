import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestoprofileComponent } from './restoprofile.component';

describe('RestoprofileComponent', () => {
  let component: RestoprofileComponent;
  let fixture: ComponentFixture<RestoprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestoprofileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RestoprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
