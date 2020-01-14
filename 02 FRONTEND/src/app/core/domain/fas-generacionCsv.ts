import { Field } from './generic.domain';
export class FasGeneracionCsv{
  constructor(
      private identificacion?: number,
      private calculoBeneficio?: number, 
      private fechaAporte?: any
  )
{}
}