import { Messaggio } from './Messaggio';
import { Chat } from './chat';

export class RegistrazioneDto{
  contatti: Chat [];
  messaggi: Messaggio[];
  sessione: string;
}
