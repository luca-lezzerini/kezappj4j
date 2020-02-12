import { Chat } from './chat2';
import { Messaggio } from './messaggio2';

export class RegistrazioneDto {
  contatti: Chat[];
  messaggi: Messaggio[];
  sessione: string;
}
