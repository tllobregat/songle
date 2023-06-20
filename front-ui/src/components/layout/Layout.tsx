import React, { useState } from 'react';
import { ScrollRestoration } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import Header from './Header';
import GlobalErrorBoundary from '../theme/GlobalErrorBoundary';

type Props = {
  children: React.ReactNode;
};

export default function Layout({ children }: Props) {
  const [showHelp, setShowHelp] = useState<boolean>();

  return <GlobalErrorBoundary>
    <Header showHelp={() => setShowHelp(true)} />
    <div className="content-layout">
      {children}
      {
        showHelp && <div className="popin-help-container" onClick={() => setShowHelp(false)}>
          <div className="popin-help">
            <span>How it works ?</span>
            <ul>
              <li>1. Play the song</li>
              <li>2. Guess it using either artist name or song name</li>
              <li>3. You will be prompted autocomplete :)</li>
              <li>4. Share your results on social networks and with friends !</li>
            </ul>
          </div>
        </div>
      }
    </div>
    <ScrollRestoration />
    <ToastContainer />
  </GlobalErrorBoundary>;
}
