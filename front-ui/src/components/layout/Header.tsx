import React from 'react';
import useMessages from '../../i18n/hooks/messagesHook';
import Logo from '../../../assets/icons/logo.png'

type Props = {
  showHelp: () => void
}

export default function Header({ showHelp }: Props) {
  const { messages } = useMessages();

  return (
    <header id="main-header">
      <img src={Logo} alt="logo" />
      <h1>{messages['home.title']}</h1>
      <div className="help" onClick={showHelp}>
        ?
      </div>
    </header>
  );
}
