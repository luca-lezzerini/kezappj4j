import { Messaggio } from './Messaggio';
import { Chat } from './Chat';

export class RegistrazioneDto {
  contatti: Chat[];
  messaggi: Messaggio[];
  sessione: string;
}
