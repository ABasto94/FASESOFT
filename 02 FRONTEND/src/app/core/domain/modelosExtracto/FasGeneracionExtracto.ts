import { creditos } from "./FasCreditosPagosTipo";
import { convenios } from "./FasConveniosTiposPagos";
import { ahorroVoluntario } from "./FasExtAhorroVoluntario";
import { ahorroAfiliado } from "./FasExtAhorrosAfiliados";

export class FasGeneracionExtracto {
    public ahorroAfiliado:ahorroAfiliado;
    public ahorroVoluntario:ahorroVoluntario[];
    public convenios :convenios[];
    public creditos :creditos[];

    public saldoConvenios: number;
    public saldoCreditos: number;
    public saldoOtroAhorros: number;
    public seleccionado: boolean;
}