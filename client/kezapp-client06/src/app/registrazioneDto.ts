import { Chat } from './Chat';
import { Messaggio } from './messaggio';

export class RegistrazioneDto {
  contatti: Chat[];
  messaggi: Messaggio[];
  sessione: string;
}
