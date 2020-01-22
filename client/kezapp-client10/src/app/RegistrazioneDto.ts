import { Chat } from './Chat';
import { Messaggio } from './Messaggio';

export class RegistrazioneDto  {
    contatti: Chat[];
    messaggi: Messaggio[];
    sessione: string;
  }